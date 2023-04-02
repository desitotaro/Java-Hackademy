public class StudentKey {
    
    String code;
    int prog;
    
    public StudentKey(String code, int prog) {
        this.code = code;
        this.prog = prog;
    }
    
    @Override
    public int hashCode(){
        final int prime = 31; 
        int result = 1; 
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + prog;
        return result;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        StudentKey other = (StudentKey) obj;
        if(code == null){
            if(other.code != null) return false;
        } else if(!code.equals(other.code)) return false;
        if(prog != other.prog) return false;
        
        return true;
    }
}
