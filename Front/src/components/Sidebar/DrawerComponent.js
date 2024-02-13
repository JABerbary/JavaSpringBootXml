import React, { useState } from "react";
import Drawer from "@mui/material/Drawer";
import Toolbar from "@mui/material/Toolbar";
import List from "@mui/material/List";
import Divider from "@mui/material/Divider";
import ListItemComponent from "./ListItemComponent";
import Box from "@mui/material/Box";
import GridDados from "../Grids/GridDados";
import GridArquivos from "../Grids/GridArquivos";
import "./Sidebar.scss";
export default function DrawerComponent() {
  const [showGrid, setShowGrid] = useState("dados"); // Estado inicial para exibir GridDados

  const handleListItemClick = (grid) => {
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
        <Divider />
        <List>
          {[
            { text: "Visualizar dados XML", grid: "dados" },
            { text: "Visualizar arquivo", grid: "arquivos" },
          ].map(({ text, grid }, index) => (
            <ListItemComponent
              key={text}
              text={text}
              index={index}
              onClick={() => handleListItemClick(grid)}
            />
          ))}
        </List>
      </Drawer>

      <Box component="main" className="main-container">
        <Toolbar />
        {showGrid === "dados" && <GridDados />}
        {showGrid === "arquivos" && <GridArquivos />}
      </Box>
    </>
  );
}
