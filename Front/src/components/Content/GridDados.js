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

// const rows = [
//   {
//     id: 1,
//     cnpj: "12345678901234",
//     cnpjdest: "98765432109876",
//     cuf: "SP",
//     dh_emi: "2024-02-13T12:00:00",
//     id_nfse: "NFSE-123",
//     nnf: "001",
//     vnf: 100.0,
//     v_tot_trib: 20.0,
//     x_fant: "Empresa Fantasia",
//     x_nome: "Empresa Nome",
//   },
//   {
//     id: 2,
//     cnpj: "23456789012345",
//     cnpjdest: "87654321098765",
//     cuf: "RJ",
//     dh_emi: "2024-02-13T12:15:00",
//     id_nfse: "NFSE-456",
//     nnf: "002",
//     vnf: 150.0,
//     v_tot_trib: 25.0,
//     x_fant: "Outra Fantasia",
//     x_nome: "Outro Nome",
//   },
//   // Adicione outras linhas conforme necessário
// ];

export default function GridDados() {
  const [rows, setRows] = useState([]);
  useEffect(() => {
    axios
      .get("http://127.0.0.1:8080/buscartodosxml") // Substitua 'URL_DO_SEU_BACKEND' pela URL real do seu backend
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
