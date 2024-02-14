import React from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import "./Styles/Sidebar.scss";
export default function ToolbarComponent() {
  return (
    <AppBar className="app-bar">
      <Toolbar>
        <div className="app-bar-title">
          <Typography>XML visualizador</Typography>
        </div>
      </Toolbar>
    </AppBar>
  );
}
