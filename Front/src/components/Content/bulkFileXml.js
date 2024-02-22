import React, { useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Snackbar from "@mui/material/Snackbar";
import MuiAlert from "@mui/material/Alert";
import "./Styles/content.scss";

export default function BulkFileXml() {
  const [files, setFiles] = useState([]);
  const [snackbarOpen, setSnackbarOpen] = useState(false);
  const [dropMsg] = useState(
    /*" Arraste o arquivo nesta área ou */ "Clique aqui para fazer upload"
  );

  const handleCloseSnackbar = () => {
    setSnackbarOpen(false);
  };

  const traditionalFileUpload = (e) => {
    const selectedFiles = Array.from(e.target.files);
    setFiles(selectedFiles);
  };

  async function readFiles() {
    let filesContentArr = [];

    const promises = files.map((file) => {
      return new Promise((resolve) => {
        const reader = new FileReader();

        reader.onload = (evt) => {
          const content = evt.target.result;
          if (content) {
            filesContentArr.push(content);
            console.log("content", content);
          }
          resolve();
        };

        if (file) {
          reader.readAsText(file);
        }
      });
    });

    await Promise.all(promises);

    console.log(filesContentArr);

    return filesContentArr;
  }

  async function handleFileUpload() {
    const arrXmlContent = await readFiles();

    const requestBody = {
      xmlFiles: arrXmlContent,
    };

    fetch("http://127.0.0.1:8080/processarxml", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestBody),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to save XML");
        }
      })
      .catch((error) => {
        console.error("Error saving XML:", error);
      });
  }

  return (
    <>
      <div className="container">
        <div className="content-zone">
          <div className={`info`}>
            <div className="drop-or-upload">
              <h3>
                <label htmlFor="fileUpload" className="custom-link">
                  <input
                    id="fileUpload"
                    type="file"
                    hidden
                    accept="application/xml"
                    onChange={(e) => traditionalFileUpload(e)}
                    multiple
                  />
                  {dropMsg}
                </label>
              </h3>
            </div>
            {files && files.length > 0 && (
              <small className="file-name">
                <>
                  Arquivo(s) selecionado(s):
                  <ul>
                    {files.map((f, i) => {
                      return <li key={i}>{f.name}</li>;
                    })}
                  </ul>
                </>
              </small>
            )}
          </div>
        </div>
      </div>
      <Box className="buttonContainer">
        <Button
          variant="contained"
          color="primary"
          onClick={() => handleFileUpload()}
          multiple
        >
          Salvar
        </Button>
      </Box>
      <Snackbar
        open={snackbarOpen}
        autoHideDuration={6000}
        onClose={handleCloseSnackbar}
        anchorOrigin={{ vertical: "top", horizontal: "center" }}
      >
        <MuiAlert
          elevation={6}
          variant="filled"
          onClose={handleCloseSnackbar}
          severity="success"
        >
          Upload bem-sucedido!
        </MuiAlert>
      </Snackbar>
    </>
  );
}
