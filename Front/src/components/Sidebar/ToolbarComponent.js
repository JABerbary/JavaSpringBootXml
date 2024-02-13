import React from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import "./Sidebar.scss";
export default function ToolbarComponent() {
  return (
    <AppBar position="fixed" className="app-bar">
      <Toolbar>
        <Typography variant="h6" noWrap component="div">
          XML
        </Typography>
      </Toolbar>
    </AppBar>
  );
}
