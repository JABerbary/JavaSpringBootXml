import * as React from "react";
import Box from "@mui/material/Box";
import { DataGrid } from "@mui/x-data-grid";
import "./GridStyle.scss";

const columns = [
  { field: "id", headerName: "id", width: 130 },
  { field: "cnpj", headerName: "cnpj", width: 130 },
  { field: "cnpjdest", headerName: "cnpjdest", width: 160 },
  { field: "cuf", headerName: "cuf", width: 130 },
  { field: "dh_emi", headerName: "dh_emi", width: 130 },
  { field: "id_nfse", headerName: "id_nfse", width: 160 },
  { field: "nnf", headerName: "nnf", width: 130 },
  { field: "vnf", headerName: "vnf", width: 130 },
  { field: "v_tot_trib", headerName: "v_tot_trib", width: 160 },
  { field: "x_fant", headerName: "x_fant", width: 130 },
  { field: "x_nome", headerName: "x_nome", width: 130 },
];

const rows = [
  {
    id: 1,
    cnpj: "12345678901234",
    cnpjdest: "98765432109876",
    cuf: "SP",
    dh_emi: "2024-02-13T12:00:00",
    id_nfse: "NFSE-123",
    nnf: "001",
    vnf: 100.0,
    v_tot_trib: 20.0,
    x_fant: "Empresa Fantasia",
    x_nome: "Empresa Nome",
  },
  {
    id: 2,
    cnpj: "23456789012345",
    cnpjdest: "87654321098765",
    cuf: "RJ",
    dh_emi: "2024-02-13T12:15:00",
    id_nfse: "NFSE-456",
    nnf: "002",
    vnf: 150.0,
    v_tot_trib: 25.0,
    x_fant: "Outra Fantasia",
    x_nome: "Outro Nome",
  },
  // Adicione outras linhas conforme necessário
];

export default function GridDados() {
  //o axios vai funcionar aqui
  return (
    <Box>
      <DataGrid rows={rows} columns={columns} />
    </Box>
  );
}
