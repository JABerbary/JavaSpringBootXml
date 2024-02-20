import React, { useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Snackbar from "@mui/material/Snackbar";
import MuiAlert from "@mui/material/Alert";
import "./Styles/content.scss";

export default function BulkFileXml() {
  const [selectedMethod, setSelectedMethod] = useState("file");
  const [files, setFiles] = useState([]);
  const [dragState, setDragState] = useState(false);
  const [snackbarOpen, setSnackbarOpen] = useState(false);
  const [dropMsg, setDropMsg] = useState(
    "Arraste o arquivo nesta área ou clique para fazer upload"
  );

  const dropFileUpload = (e) => {
    e.preventDefault();
    const fileList = e.dataTransfer.files;
    const reader = new FileReader();
    reader.onload = function (e) {
      const xmlContent = e.target.result;
      const blob = new Blob([xmlContent], { type: "text/xml" });
      console.log(xmlContent);
      handleSave(blob);
    };
    for (let i = 0; i < fileList.length; i++) {
      reader.readAsText(fileList[i]);
    }
  };

  const handleDragEnter = (e) => {
    setDragState(true);
  };
  const handleDragLeave = (e) => {
    setDragState(false);
  };
  const handleCloseSnackbar = (event, reasson) => {
    setSnackbarOpen(false);
  };

  const traditionalFileUpload = (e) => {
    const selectedFiles = Array.from(e.target.files);
    setFiles(selectedFiles);
  };

  const handleSave = (blob) => {
    const formData = new FormData();
    const newReader = new FileReader();

    for (let i = 0; i < files.length; i++) {
      formData.append(`file${i + 1}`, files[i]);
    }

    setTimeout(() => {
      setSnackbarOpen(true);
      setFiles([]);
    }, 2000);

    newReader.onload = function (event) {
      const xmlContent = event.target.result;
      console.log(xmlContent);
      fetch("http://127.0.0.1:8080/processarxml", {
        method: "POST",
        headers: {
          Accept: "application/xml",
          "Content-Type": "application/xml",
        },
        body: xmlContent,
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error("Failed to save XML");
          }
        })
        .catch((error) => {
          console.error("Error saving XML:", error);
        });
    };

    newReader.readAsText(blob);
  };

  const _textContent = (value) => {};
  const dragOverHandler = (e) => {};

  return (
    <>
      <div className="container">
        <div
          onDrop={(e) => dropFileUpload(e)}
          onDragOver={(e) => dragOverHandler(e)}
          onDragEnter={(e) => handleDragEnter(e)}
          onDragLeave={(e) => handleDragLeave(e)}
          className="content-zone"
        >
          {selectedMethod === "file" && (
            <div className={`info ${dragState && "drop-enabled"}`}>
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
          )}
          {selectedMethod === "text" && (
            <>
              <textarea
                className="text-box"
                placeholder="Cole o conteúdo do XML aqui"
                onChange={(e) => _textContent(e.target.value)}
              />
            </>
          )}
        </div>
      </div>
      <Box className="buttonContainer">
        <Button
          variant="contained"
          color="primary"
          onClick={() => {
            files.forEach((file) => handleSave(file));
          }}
          multiple
        >
          Salvar
        </Button>
      </Box>
      {/* {uploadSuccess && (
        <div className="success-message">Upload bem-sucedido!</div>
      )} */}
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
