

public class Team {
	private String teamCode;
	private String teamName;
	private String teamColor;
	private String teamLeader;
	private String teamMember;
	
	Team(){
		
	}
	
	private void setTeamCode(String Code) {
		
		this.teamCode = Code;
	}
	
	public void setTeamColor(Players player) {
		
		if (player.getSeniority()>5) {
			setTeamCode("5+");
			this.teamColor = "red";
		}
		else if(player.getSeniority() == 5) {
			setTeamCode("5=");
			this.teamColor = "blue";
		}
		else {
			setTeamCode("5-");
			this.teamColor = "yellow";
		}
		;
	}
	public String getTeamColor() {
		return teamColor;
	}
	public String getTeamCode() {
		return teamCode;
	}

}
