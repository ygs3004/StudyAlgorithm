class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        Time time = new Time(pos);
        time.setMax(video_len);
        
        Time opStart = new Time(op_start);
        Time opEnd = new Time(op_end);
        checkOpening(time, opStart, opEnd);
        
        for(String command: commands){
            time.oper(command);
            checkOpening(time, opStart, opEnd);
        }

        return time.toString();
    }
    
    void checkOpening(Time time, Time opStart, Time opEnd){
        boolean isAfterStart = time.m > opStart.m || (time.m == opStart.m && time.s >= opStart.s);
        boolean isBeforeEnd = time.m < opEnd.m || (time.m == opEnd.m && time.s <= opEnd.s);
        if(isAfterStart && isBeforeEnd){
            time.m = opEnd.m;
            time.s = opEnd.s;
        }
    }
    
    private class Time{
        int m;
        int s;
        int maxM = 60;
        int maxS = 60;
        
        Time(String time){
            String[] info = time.split(":");
            this.m = Integer.parseInt(info[0]);
            this.s = Integer.parseInt(info[1]);
        }
        
        void setMax(String maxTime){
            String[] info = maxTime.split(":");
            this.maxM = Integer.parseInt(info[0]);
            this.maxS = Integer.parseInt(info[1]);
        }
        
        void oper(String command){
            if(command.equals("next")){
                this.next();
            }else if(command.equals("prev")){
                this.prev();
            }
        }
        
        void next(){
            this.s += + 10;
            if(this.s >= 60){
                this.s -= 60;
                this.m++;
            }
            
            if(this.m >= this.maxM && this.s >= this.maxS){
                this.m = this.maxM;
                this.s = this.maxS;
            }
        }
                
        void prev(){
            this.s -= 10;
            if(this.s < 0){
                if(this.m == 0){
                    this.m = 0;
                    this.s = 0;
                }else{
                    this.s = 60 + this.s;
                    this.m--;
                }
            }
            
        }

        @Override
        public String toString(){
            return this.lpad(this.m) + ":" + this.lpad(this.s);
        }
                     
        public String lpad(int num){
            return num < 10 ? "0" + String.valueOf(num) : String.valueOf(num);
        }
    }

}