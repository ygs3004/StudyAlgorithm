function solution(score) {
    
    let rankInfo = {};
    let rank = 1;
    let saveRank = 0;
    
    score.map( v => v[0]+v[1]).sort( (a,b) => b-a ).forEach( v => {
        if(!rankInfo[v]){
            rankInfo[v] = rank++;
        }else{
            rank++;
        }
    })

    return score.map( v => rankInfo[v[0]+v[1]] );

}