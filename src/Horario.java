
public class Horario {

	public static final String SEGUNDA = "SEG";
	public static final String TERCA = "TER";
	public static final String QUARTA = "QUA";
	public static final String QUINTA = "QUI";
	public static final String SEXTA = "SEXTA";
	private int horaInicio;
	private int horaFim;
	private String diaDaSemana;
	
	public Horario(String diaDaSemana, int horaInicio, int horaFim){
		this.diaDaSemana = diaDaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		if (diaDaSemana == null) {
			if (other.diaDaSemana!= null)
				return false;
		} else if (!diaDaSemana.equals(other.diaDaSemana)){
			return false;
		}
		if(diaDaSemana.equals(other.diaDaSemana)){
			if(horaInicio == (other.horaInicio)){
				if(horaFim == (other.horaFim)){
					return true;
				}
			}
		}
		return false;
	}
	
	
}
