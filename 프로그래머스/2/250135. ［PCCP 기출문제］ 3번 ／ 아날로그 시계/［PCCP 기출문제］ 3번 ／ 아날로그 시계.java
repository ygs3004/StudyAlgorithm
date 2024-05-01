class Solution {
    
    int result;
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        Clock clock = new Clock(h1, m1, s1);
        do{
            clock.addOneSec();
        }while(!clock.isSameTime(h2, m2, s2));
        
        return result;
    }
    
    private class Clock{
        int h;
        int m;
        int s;
        double degreeH;
        double degreeM;
        double degreeS;

        Clock(int h, int m, int s){
            this.h = h;
            this.m = m;
            this.s = s;
            calculateDegree();
            // 초기에 겹칠경우
            if(this.degreeH == this.degreeS || this.degreeH == this.degreeM || this.degreeM == this.degreeS) result++;
        }
        
        private void addOneSec(){
            double beforeDegreeH = this.degreeH;
            double beforeDegreeM = this.degreeM;
            double beforeDegreeS = this.degreeS;
            this.s++;
            if(this.s == 60){
                addOneMin();
                this.s = 0;
            }
                        
            calculateDegree();
            double afterDegreeH = this.degreeH < beforeDegreeH ? degreeH + 360 : degreeH;
            double afterDegreeM = this.degreeM < beforeDegreeM ? degreeM + 360 : degreeM;
            double afterDegreeS = this.degreeS < beforeDegreeS ? degreeS + 360 : degreeS;
            
            // 시분초침이 겹칠 경우
            if(this.h == 12 && this.m == 0 && this.s ==0){
                result++;
            }else{
                // 초침이 분침을 지났을 경우
                boolean isStackSM = beforeDegreeS < beforeDegreeM && afterDegreeS >= afterDegreeM;
                if(isStackSM){
                    result++;
                }
                // 초침이 시침을 지났을 경우
                boolean isStackSH = beforeDegreeS < beforeDegreeH && afterDegreeS >= afterDegreeH;
                if(isStackSH){
                    result++;
                }
            }
        }
        
        private void addOneMin(){
            this.m++;
            if(this.m == 60){
                this.h++;
                this.m=0;
            }
        }
        
        private void calculateDegree(){
            calculateDegreeH();
            calculateDegreeM();
            calculateDegreeS();
        }
            
        private void calculateDegreeH(){
            this.degreeH = (h%12*360)/(double)(12)
                + (this.m*360)/(double)(12*60)
                + (this.s*360)/(double)(12*60*60);
        }
        
        private void calculateDegreeM(){
            this.degreeM = (this.m*360/(double)60)
                + (this.s*360/(double)(60*60));
        }
        
        private void calculateDegreeS(){
            this.degreeS = (this.s*360)/(double)(60);
        }
        
        public boolean isSameTime(int h, int m, int s){
            return this.h == h && this.m == m && this.s == s;
        }
    }
    
}