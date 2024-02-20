import Box from "@mui/material/Box";
import { DataGrid } from "@mui/x-data-grid";
import React, { useState, useEffect } from "react";
import axios from "axios";

const columns = [
  { field: "id", headerName: "ID", width: 20 },
  { field: "cnpj", headerName: "CNPJ", width: 160 },
  { field: "cnpjdest", headerName: "CNPJ Destino", width: 160 },
  { field: "cuf", headerName: "UF", width: 20 },
  { field: "dh_emi", headerName: "Data/Hora Emissão", width: 120 },
  { field: "id_nfse", headerName: "ID NFSE", width: 120 },
  { field: "nnf", headerName: "NNF", width: 120 },
  { field: "vnf", headerName: "VNF", width: 120 },
  { field: "v_tot_trib", headerName: "Valor Total Tributado", width: 120 },
  { field: "x_fant", headerName: "Nome Fantasia", width: 120 },
  { field: "x_nome", headerName: "Nome", width: 120 },
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
