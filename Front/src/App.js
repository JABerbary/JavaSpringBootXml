import React from "react";
import Box from "@mui/material/Box";
import Drawer from "./components/Sidebar/drawerComponent";
// import CssBaseline from "@mui/material/CssBaseline";
import Toolbar from "./components/Sidebar/toolbarComponent";
import "./App.css";

function App() {
  return (
    <>
      <Box sx={{ display: "flex" }}>
        {/* <CssBaseline /> */}
        <Toolbar />
        <Drawer />
      </Box>
    </>
  );
}

export default App;
