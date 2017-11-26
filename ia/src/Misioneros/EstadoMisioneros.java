package Misioneros;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

public class EstadoMisioneros {
	private int numMisioneros; // numMisioneros en orilla izquierda
	private int numCanibales; // numCanibales en orilla izquierda
	private boolean barcaIzq; // true si barca en orilla izquierda

	public static Action M = new DynamicAction("M");
	public static Action MM = new DynamicAction("MM");
	public static Action C = new DynamicAction("C");
	public static Action CC = new DynamicAction("CC");
	public static Action MC = new DynamicAction("MC");

	public EstadoMisioneros() {
		this(3, 3, true);
	}

	public EstadoMisioneros(EstadoMisioneros mc) {
		this(mc.getnMisioneros(), mc.getnCanibales(), mc.isBarcaIzq());
	}

	public EstadoMisioneros(int nMisioneros, int nCanibales, boolean barcaIzq) {
		this.numMisioneros = nMisioneros;
		this.numCanibales = nCanibales;
		this.barcaIzq = barcaIzq;
	}

	public int getnMisioneros() {

		return this.numMisioneros;
	}

	public int getnCanibales() {

		return this.numCanibales;
	}

	public boolean isBarcaIzq() {
		return this.barcaIzq;
	}

	/*
	 * tenemos que definir lo estador y operadores pres y post
	 */
	public void moveM() {
		if (this.barcaIzq)
			this.numMisioneros--;
		else
			this.numMisioneros++;

		cambiarDeOrilla();

	}

	public void moveMM() {
		if (this.barcaIzq)
			this.numMisioneros = this.numMisioneros - 2;
		else
			this.numMisioneros = this.numMisioneros + 2;

		cambiarDeOrilla();

	}

	public void moveC() {
		if (this.barcaIzq)
			this.numCanibales--;
		else
			this.numCanibales++;

		cambiarDeOrilla();

	}

	public void moveCC() {
		if (this.barcaIzq)
			this.numCanibales = this.numCanibales - 2;
		else
			this.numCanibales = this.numCanibales + 2;

		cambiarDeOrilla();

	}

	public void moveMC() {
		if (this.barcaIzq) {
			this.numMisioneros--;
			this.numCanibales--;
		} else {
			this.numMisioneros++;
			this.numCanibales++;
		}
		cambiarDeOrilla();

	}

	public void cambiarDeOrilla() {

		this.barcaIzq = (this.barcaIzq) ? false : true;

	}

	public boolean movimientoValido(Action where) {
		boolean valido = false;

		if (where.equals(M)) {
			if ((barcaIzq && numMisioneros > 0) || (!barcaIzq && this.numMisioneros < 3)) {
				EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
				estadoSiguiente.moveM();
				valido = !estadoSiguiente.peligro();
			} else
				valido = false;

		} else if (where.equals(MM)) { // Lo hemos puesto nosotros
			if ((barcaIzq && numMisioneros > 1) || (!barcaIzq && this.numMisioneros < 2)) {
				EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
				estadoSiguiente.moveMM();
				valido = !estadoSiguiente.peligro();
			} else
				valido = false;
		}

		if (where.equals(C)) {
			if ((barcaIzq && numCanibales > 0) || (!barcaIzq && this.numCanibales < 3)) {
				EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
				estadoSiguiente.moveC();
				valido = !estadoSiguiente.peligro();
			} else
				valido = false;

		} else if (where.equals(CC)) { // Lo hemos puesto nosotros
			if ((barcaIzq && numCanibales > 1) || (!barcaIzq && this.numCanibales < 2)) {
				EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
				estadoSiguiente.moveCC();
				valido = !estadoSiguiente.peligro();
			} else
				valido = false;
		} else if (where.equals(MC)) { // Lo hemos puesto nosotros
			if ((barcaIzq && numCanibales > 0) && (barcaIzq && numMisioneros > 0) || (!barcaIzq && this.numCanibales < 3) && (!barcaIzq && this.numMisioneros < 3)) { // Pensar bien estas condiciones del if que estan mal
				EstadoMisioneros estadoSiguiente = new EstadoMisioneros(this);
				estadoSiguiente.moveMC();
				valido = !estadoSiguiente.peligro();
			} else
				valido = false;
		}

		return valido;
	}

	private boolean peligro() {

		if (((this.numMisioneros < this.numCanibales) && (this.numMisioneros != 0))
				|| ((this.numMisioneros > this.numCanibales) && (this.numMisioneros != 3)))
			return true;
		else
			return false;

	}

	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		}

		EstadoMisioneros otroEstado = (EstadoMisioneros) o;

		if ((this.numMisioneros == otroEstado.getnMisioneros()) && (this.numCanibales == otroEstado.getnCanibales())
				&& (this.barcaIzq == otroEstado.barcaIzq))
			return true;
		else
			return false;

	}

	public int hashCode() {
		return (100 * numMisioneros) + (10 * numCanibales) + (barcaIzq ? 1 : 0);
	}

}
