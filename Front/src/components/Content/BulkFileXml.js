import React, { useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import "./Styles/content.scss";

export default function BulkFileXml() {
  const [selectedMethod, setSelectedMethod] = useState("file"); // Estado para acompanhar o método selecionado (arquivo ou texto)
  const [files, setFiles] = useState([]); // Estado para acompanhar os arquivos selecionados
  const [dragState, setDragState] = useState(false); // Estado para acompanhar o estado de arrasto
  const [dropMsg, setDropMsg] = useState(
    "Arraste o arquivo nesta área ou clique para fazer upload"
  ); // Estado para exibir a mensagem de soltar

  const dropFileUpload = (e) => {
    // Lógica para manipular o evento de soltar arquivos na área de soltar
  };

  const dragOverHandler = (e) => {
    // Lógica para manipular o evento de arrastar sobre a área de soltar
  };

  const handleDragEnter = (e) => {
    // Lógica para manipular o evento de entrada do mouse na área de soltar
    setDragState(true);
  };

  const handleDragLeave = (e) => {
    // Lógica para manipular o evento de saída do mouse da área de soltar
    setDragState(false);
  };

  const traditionalFileUpload = (e) => {
    // Lógica para manipular o evento de seleção de arquivo tradicional
    const selectedFiles = Array.from(e.target.files);
    setFiles(selectedFiles);
  };

  const _textContent = (value) => {
    // Lógica para manipular o conteúdo do texto
  };

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
                      accept="text/xml"
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
        <Button variant="contained" color="primary">
          Salvar
        </Button>
      </Box>
    </>
  );
}
