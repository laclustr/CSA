public class KenKen {
	private int n;
	private int groupCount;
	private Group[] groups;

	public KenKen() {}

	public KenKen(int n, int groupCount, Group[] groups) {
		this.n = n;
		this.groupCount = groupCount;
		this.groups = groups;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void setNGroups(int groupCount) {
		this.groupCount = groupCount;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	public void setGroup(Group group, int idx) {
		groups[idx] = group;
	}

	public int getN() {
		return n;
	}

	public int getNGroups() {
		return groupCount;
	}

	public Group[] getGroups() {
		return groups;
	}
}