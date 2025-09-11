public class MedicalRecord {
	private static int nRecords;
	private String name;
	private String patientID;
	private boolean needsTranslator;

	private String genID() {
		int a = (int) (Math.random() * 10);
		int b = (int) (Math.random() * 10);
		int c = (int) (Math.random() * 10);
		int d = (int) (Math.random() * 10);
		int e = (int) (Math.random() * 10);
		int f = (int) (Math.random() * 10);

		return "" + a + b + c + d + e + f;
	}

	public MedicalRecord(String name) {
		this.name = name;
		this.patientID = genID();
		nRecords++;
	}

	public MedicalRecord(String name, boolean needsTranslator) {
		this.name = name;
		this.needsTranslator = needsTranslator;
		this.patientID = genID();
		nRecords++;
	}

	public String toString() {
		return "({" + patientID + "}, {" + name + "}" + (needsTranslator ? ", translator required)" : ")");
 	}

 	public boolean equals(MedicalRecord other) {
 		return this.name.equals(other.name) &&
 		this.patientID.equals(other.patientID) &&
 		this.needsTranslator == other.needsTranslator;
 	}

 	public String getName() {
 		return name;
 	}

 	public void toggleTranslator() {
 		needsTranslator = !needsTranslator;
 	}

 	public String getPatientID() {
 		return patientID;
 	}

 	public static int getNumRecords() {
 		return nRecords;
 	}

 	public void clearRecord() {
 		this.name = "";
 		this.patientID = "";
 		this.needsTranslator = false;
 	}













}