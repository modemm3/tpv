package entity.base;

public interface InterfaceEntityBase
{
	public void setId(int id);
	public void setIdC(String id);
	public void setNombre(String name);
	public void setDescripcion(String description);
	public void setQuery(String Query);
	public void setTipoTransaccion(int tipoTransaction);
	public void setMensajeError(String mensajeError);
	public int getTipoTransaccion();
	public int getId();
	public String getIdC();
	public String getNombre();
	public String getDescripcion();
	public String getQuery();
	public int getStatus();
	public void setStatus(int error);
	public String getMensajeError();
	public void setMsgView(String mensaje);
	public String getMsgView();
	public int getInicialReg();
	public void setInicialReg(int inicialReg);
	public int getFinalReg();
	public void setFinalReg(int finalReg);
	public int getTotalRegistros();
	public void setTotalRegistros(int totalRegistros);
}
