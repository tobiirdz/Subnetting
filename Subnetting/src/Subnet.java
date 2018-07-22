
public class Subnet {

	private int mascaraDec;
	private String mascaraBit = "";
	private String mascaraDecPunto;
	private String host;
	//String octeto = "";
	//String ip = "";
	public static final char claseA = 'a';
	public static final char claseB = 'b';
	public static final char claseC = 'c';	
	public static final char claseD = 'D';
	//contructor
	/*public Subnet(String ip, int mascaraDec, String host) {
		//this.ip = ip;
		this.mascaraDec = mascaraDec + 1;
		this.host = host;
		mascaraBits(ip);
		//mascaraDecimal();
	}*/
	
	//metodos
	//genera los octetos
	private String mascaraBits(String ip) {
		
		//this.ip = ip; 
		String octeto = "";
		for(int i = 0; i <ip.length(); i++) {
			if(ip.charAt(i) != '.') {
				octeto += ip.charAt(i);
			}else {
				break;
			}
		}
		return octeto;
	}
	
	public char claseRed() {
		
		int octetoDec = Integer.parseInt(octeto);
		if(octetoDec <= 127 && octetoDec >= 1) {
			return claseA;
		}else if(octetoDec <= 191 & octetoDec >= 128) {
			return claseB;
		}else if(octetoDec <= 223 & octetoDec >= 192) {
			return claseC;
		}else {
			return claseD;
		}
	}
	
	public String hosts() {
		this.host = host;
		String[] h = host.split(",");
		String hts = "";
		for(int cont = 0; cont < h.length; cont++) {
			int ht = Integer.parseInt(h[cont]);
			for(int exp = 0; exp < 8; exp++) {
				int hostEnc = (int) Math.pow(2, exp) - 2;
				if(hostEnc > ht) {
					hts += hostEnc + ",";
					break;
				}
			}
			
		}
		return hts;
	}
	
	public String mascara() {
		this.mascaraDec = mascaraDec;
		this.mascaraBit = mascaraBit;
		int contador = 1, exp = 7, resInt = 0;
		String resStr = "";
		for(int bit = 0; bit < 33; bit++) {
			if(bit < mascaraDec  ) {
				mascaraBit += "1";
			}else if(bit <= 31 && bit >= mascaraDec) {
				mascaraBit += "0";
			}
			if(contador == 8) {
				mascaraBit += ".";
				contador = 0;
			}
			contador++;
		}
		//return mascaraBit;
		
		for(int bit = 0; bit < mascaraBit.length(); bit++) {
			if(mascaraBit.charAt(bit) == '1') {
				resInt = resInt + (int) Math.pow(2, exp);
				
			}else if(mascaraBit.charAt(bit) == '.') {
				resStr += String.valueOf(resInt) + '.';
				exp = 8;
				resInt = 0;
			}
			
			exp--;
		}
		return resStr;
		
	}
	
	
	public Subnet red () {
		Subnet nuevaRed = new Subnet(host, mascaraDec, host);
		return nuevaRed;
	}
		
	//getter devuelve un resultado
	public String toString() {
		return "La direccion ip: " + ip + "/" + mascaraDec + 
				" Mascara de Red: " + mascara() +
				" cantidad de hosts solicitados: " + host + 
				" cantidad de host encontrados: " + hosts() +" ";
	
	}
	
	
	
	//setter es void
	
}
