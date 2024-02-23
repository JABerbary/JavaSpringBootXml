class DataHandler {
  static formatarCNPJ(cnpj) {
    return cnpj.replace(
      /^(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})$/,
      "$1.$2.$3/$4-$5"
    );
  }

  static formatarMoeda(valor) {
    return valor.toLocaleString("pt-BR", {
      style: "currency",
      currency: "BRL",
    });
  }

  static formatarDataHora(dataHora) {
    const data = new Date(dataHora);
    return data.toLocaleString();
  }

  static ajustarDados(data) {
    return data.map((row) => ({
      ...row,
      dhemi: DataHandler.formatarDataHora(row.dhEmi),
      idnfse: row.idNfse,
      vtottrib: row.vtotTrib,
      cnpj: DataHandler.formatarCNPJ(row.cnpj),
      cnpjdest: DataHandler.formatarCNPJ(row.cnpjdest),
      vnf: DataHandler.formatarMoeda(row.vnf),
      vtottrib: DataHandler.formatarMoeda(row.vtotTrib),
    }));
  }
}

export default DataHandler;
