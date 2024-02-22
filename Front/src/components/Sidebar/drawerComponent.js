import React, { useState } from "react";
import Drawer from "@mui/material/Drawer";
import Toolbar from "@mui/material/Toolbar";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import FileIcon from "@mui/icons-material/InsertDriveFile";
import CloudUploadIcon from "@mui/icons-material/CloudUpload";
import Box from "@mui/material/Box";
import GridDados from "../Content/gridDados";
import BulkFileXml from "../Content/bulkFileXml";
import "./Styles/sidebar.scss";

export default function DrawerComponent() {
  const [showGrid, setShowGrid] = useState("dados");

  const handleGridChange = (grid) => {
    setShowGrid(grid);
  };

  return (
    <>
      <Drawer
        className="muiDrawer-root & .muiDrawer-paper"
        variant="permanent"
        anchor="left"
      >
        <Toolbar />
        <List>
          <ListItem disablePadding>
            <ListItemButton onClick={() => handleGridChange("dados")}>
              <ListItemIcon>
                <FileIcon />
              </ListItemIcon>
              Visualizar Dados XML
            </ListItemButton>
          </ListItem>
          <ListItem disablePadding>
            <ListItemButton onClick={() => handleGridChange("file")}>
              <ListItemIcon>
                <CloudUploadIcon />
              </ListItemIcon>
              Inserir Arquivos
            </ListItemButton>
          </ListItem>
        </List>
        <Toolbar />
      </Drawer>

      <Box component="main" className="main-container">
        <Toolbar />
        {showGrid === "dados" && <GridDados />}
        {showGrid === "file" && <BulkFileXml />}
      </Box>
    </>
  );
}
