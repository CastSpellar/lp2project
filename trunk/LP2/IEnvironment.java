interface IEnvironment {
	public void Assoc (String id , int val) throws Exception;
	public int Find (String id) throws Exception;
	public IEnvironment BeginScope() throws Exception;
	public IEnvironment EndScope() throws Exception;
}