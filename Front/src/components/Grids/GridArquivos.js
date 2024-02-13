import * as React from "react";
import Box from "@mui/material/Box";
import { DataGrid } from "@mui/x-data-grid";
import "./GridStyle.scss";

const columns = [
  { field: "id", headerName: "ID", width: 130 },
  { field: "xml_content", headerName: "XML Content", width: 300 },
];

const rows = [
  { id: 1, xml_content: "<xml>Conteúdo XML 1</xml>" },
  { id: 2, xml_content: "<xml>Conteúdo XML 2</xml>" },
  { id: 3, xml_content: "<xml>Conteúdo XML 3</xml>" },
  { id: 4, xml_content: "<xml>Conteúdo XML 4</xml>" },
  { id: 5, xml_content: "<xml>Conteúdo XML 5</xml>" },
  { id: 6, xml_content: "<xml>Conteúdo XML 6</xml>" },
  { id: 7, xml_content: "<xml>Conteúdo XML 7</xml>" },
  { id: 8, xml_content: "<xml>Conteúdo XML 8</xml>" },
  { id: 9, xml_content: "<xml>Conteúdo XML 9</xml>" },
  { id: 10, xml_content: "<xml>Conteúdo XML 10</xml>" },
];

export default function GridArquivos() {
  return (
    <Box>
      <DataGrid rows={rows} columns={columns} />
    </Box>
  );
}
