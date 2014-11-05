package entity.base;

public class EntityBase implements InterfaceEntityBase
{
	protected int id;
	protected String idC;
	protected String nombre;
	protected String descripcion;
	protected String query;
	protected int tipoTransaccion;
	protected int status;
	protected String mensajeError;
	private String accion;
	private String msgView;
	private int inicialReg;
	private int finalReg;
	private int totalRegistros;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getIdC()
	{
		return idC;
	}
	public void setIdC(String idC)
	{
		this.idC = idC;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public String getQuery()
	{
		return query;
	}
	public void setQuery(String query)
	{
		this.query = query;
	}
	public int getTipoTransaccion()
	{
		return tipoTransaccion;
	}
	public void setTipoTransaccion(int tipoTransaccion)
	{
		this.tipoTransaccion = tipoTransaccion;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int error)
	{
		this.status = error;
	}
	public String getMensajeError()
	{
		return mensajeError;
	}
	public void setMensajeError(String mensajeError)
	{
		this.mensajeError = mensajeError;
	}
	public String getAccion()
	{
		return accion;
	}
	public void setAccion(String accion)
	{
		this.accion = accion;
	}
	@Override
	public void setMsgView(String mensaje)
	{
		msgView=mensaje;
	}
	@Override
	public String getMsgView()
	{
		return msgView;
	}
	public int getInicialReg() {
		return inicialReg;
	}
	public void setInicialReg(int inicialReg) {
		this.inicialReg = inicialReg;
	}
	public int getFinalReg() {
		return finalReg;
	}
	public void setFinalReg(int finalReg) {
		this.finalReg = finalReg;
	}
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
}
