package entity;

import java.sql.Timestamp;

import vo.UsuariosVO;
import entity.base.EntityBase;

public class Usuarios extends EntityBase {
	private int id;
	private String nombre;
	private String password;
	private boolean activo;
	private Timestamp fechaCreacion;
	private Timestamp fechaModificacion;
	private Usuarios usuarioModifica;
	private Timestamp ultimaFechaAcceso;
	private Timestamp periodoCambioContrasenia;
	private boolean habilitarCambioContrasenia;
	private int noDiasAnticipadosCambContrasenia;
	private int noSesiones;
	private String respuestaSecreta;
	private int idUsuario;

	public Usuarios() {
		super();
	}

	public Usuarios(UsuariosVO usuariosVO) {
		this.id = usuariosVO.getId();
		this.nombre = usuariosVO.getNombre();
		this.password = usuariosVO.getPassword();
		this.activo = usuariosVO.isActivo();
		this.fechaCreacion = usuariosVO.getFechaCreacion();
		this.fechaModificacion = usuariosVO.getFechaModificacion();
		if (usuariosVO.getUsuarioModificaVO() != null) {
			UsuariosVO userVO = new UsuariosVO();
			userVO.setId(usuariosVO.getUsuarioModificaVO().getId());
			Usuarios user = new Usuarios();
			user.setId(userVO.getId());
			this.usuarioModifica = user;
		}

		this.ultimaFechaAcceso = usuariosVO.getUltimaFechaAcceso();
		this.periodoCambioContrasenia = usuariosVO
				.getPeriodoCambioContrasenia();
		this.habilitarCambioContrasenia = usuariosVO
				.getHabilitarCambioContrasenia();
		this.noDiasAnticipadosCambContrasenia = usuariosVO
				.getNoDiasAnticipadosCambContrasenia();
		this.noSesiones = usuariosVO.getNoSesiones();
		this.respuestaSecreta = usuariosVO.getRespuestaSecreta();

		this.setStatus(usuariosVO.getStatus());
		this.setInicialReg(usuariosVO.getInicialReg());
		this.setFinalReg(usuariosVO.getFinalReg());
		this.setTotalRegistros(usuariosVO.getTotalRegistros());
	}

	public Usuarios(int id, String nombre, String password, boolean activo,
			Timestamp fechaCreacion, Timestamp fechaModificacion,
			int idUsuario, Timestamp ultimaFechaAcceso,
			Timestamp periodoCambioContrasenia,
			boolean habilitarCambioContrasenia,
			int noDiasAnticipadosCambContrasenia, int noSesiones,
			String respuestaSecreta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.activo = activo;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		// this.idUsuario = idUsuario;
		this.ultimaFechaAcceso = ultimaFechaAcceso;
		this.periodoCambioContrasenia = periodoCambioContrasenia;
		this.habilitarCambioContrasenia = habilitarCambioContrasenia;
		this.noDiasAnticipadosCambContrasenia = noDiasAnticipadosCambContrasenia;
		this.noSesiones = noSesiones;
		this.respuestaSecreta = respuestaSecreta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Timestamp getUltimaFechaAcceso() {
		return ultimaFechaAcceso;
	}

	public void setUltimaFechaAcceso(Timestamp ultimaFechaAcceso) {
		this.ultimaFechaAcceso = ultimaFechaAcceso;
	}

	public Timestamp getPeriodoCambioContrasenia() {
		return periodoCambioContrasenia;
	}

	public void setPeriodoCambioContrasenia(Timestamp periodoCambioContrasenia) {
		this.periodoCambioContrasenia = periodoCambioContrasenia;
	}

	public boolean getHabilitarCambioContrasenia() {
		return habilitarCambioContrasenia;
	}

	public void setHabilitarCambioContrasenia(boolean habilitarCambioContrasenia) {
		this.habilitarCambioContrasenia = habilitarCambioContrasenia;
	}

	public int getNoDiasAnticipadosCambContrasenia() {
		return noDiasAnticipadosCambContrasenia;
	}

	public void setNoDiasAnticipadosCambContrasenia(
			int noDiasAnticipadosCambContrasenia) {
		this.noDiasAnticipadosCambContrasenia = noDiasAnticipadosCambContrasenia;
	}

	public int getNoSesiones() {
		return noSesiones;
	}

	public void setNoSesiones(int noSesiones) {
		this.noSesiones = noSesiones;
	}

	public String getRespuestaSecreta() {
		return respuestaSecreta;
	}

	public void setRespuestaSecreta(String respuestaSecreta) {
		this.respuestaSecreta = respuestaSecreta;
	}

	public Usuarios getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(Usuarios usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
