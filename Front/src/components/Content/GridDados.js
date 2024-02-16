import Box from "@mui/material/Box";
import { DataGrid } from "@mui/x-data-grid";
import React, { useState, useEffect } from "react";
import axios from "axios";

const columns = [
  { field: "id", headerName: "ID", width: 130 },
  { field: "cnpj", headerName: "CNPJ", width: 150 },
  { field: "cnpjdest", headerName: "CNPJ Destino", width: 180 },
  { field: "cuf", headerName: "UF", width: 100 },
  { field: "dh_emi", headerName: "Data/Hora Emissão", width: 180 },
  { field: "id_nfse", headerName: "ID NFSE", width: 160 },
  { field: "nnf", headerName: "NNF", width: 100 },
  { field: "vnf", headerName: "VNF", width: 100 },
  { field: "v_tot_trib", headerName: "Valor Total Tributado", width: 200 },
  { field: "x_fant", headerName: "Nome Fantasia", width: 180 },
  { field: "x_nome", headerName: "Nome", width: 130 },
];

export default function GridDados() {
  const [rows, setRows] = useState([]);
  useEffect(() => {
    axios
      .get("http://127.0.0.1:8080/buscartodosxml")
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
