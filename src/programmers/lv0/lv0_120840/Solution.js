function solution(balls, share) {
        let numerator = 1;
        let denonimator = 1;

        if(balls-share > share){
            for(let i=balls; i>balls-share; i--){
                numerator *= i;
            }   
            for(let i=share; i>1; i--){
                denonimator *= i;
            }
        }else{
            for(let i=balls; i>share; i--){
                numerator *= i;
            }
            for(let i=balls-share; i>1; i--){
                denonimator *= i;
            }
        }
        
        return numerator/denonimator;
}