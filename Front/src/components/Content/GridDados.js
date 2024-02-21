import Box from "@mui/material/Box";
import { DataGrid } from "@mui/x-data-grid";
import React, { useState, useEffect } from "react";
import axios from "axios";

const columns = [
  { field: "id", headerName: "ID", width: 20 },
  { field: "cnpj", headerName: "CNPJ", width: 160 },
  { field: "cnpjdest", headerName: "CNPJ Destino", width: 160 },
  { field: "cuf", headerName: "UF", width: 20 },
  { field: "dhemi", headerName: "Data/Hora Emissão", width: 120 },
  { field: "idnfse", headerName: "ID NFSE", width: 120 },
  { field: "nnf", headerName: "NNF", width: 120 },
  { field: "vnf", headerName: "VNF", width: 120 },
  { field: "vtottrib", headerName: "Valor Total Tributado", width: 120 },
  { field: "xfant", headerName: "Nome Fantasia", width: 120 },
  { field: "xnome", headerName: "Nome", width: 120 },
  {
    field: "download",
    headerName: "Download XML",
    width: 150,
    renderCell: (params) => {
      const handleDownload = () => {
        const url = `http://127.0.0.1:8080/exibirxml/${params.row.id}`;
        console.log("URL de download:", url);
        fetch(url, {
          method: "GET",
          headers: {
            "Content-Type": "application/xml",
          },
        })
          .then((response) => response.text()) // Alterado para response.text() para obter o texto do XML
          .then((xmlText) => {
            const parser = new DOMParser();
            const xmlDoc = parser.parseFromString(xmlText, "text/xml");
            const xmlContent = xmlDoc.querySelector("xmlContent").textContent;
            const blob = new Blob([xmlContent], { type: "application/xml" });
            const url = window.URL.createObjectURL(blob);
            const link = document.createElement("a");
            link.href = url;
            link.setAttribute("download", `xml_${params.row.id}.xml`);
            document.body.appendChild(link);
            link.click();
          })
          .catch((error) => {
            console.error("Erro ao baixar o XML:", error);
          });
      };

      return <button onClick={handleDownload}>Baixar XML</button>;
    },
  },
];

export default function GridDados() {
  const [rows, setRows] = useState([]);
  useEffect(() => {
    axios
      .get("http://127.0.0.1:8080/buscartodosnfse")
      .then((response) => {
        setRows(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar dados:", error);
      });
  }, []);

  return (
    <Box>
      <DataGrid rows={rows} columns={columns} />
    </Box>
  );
}
