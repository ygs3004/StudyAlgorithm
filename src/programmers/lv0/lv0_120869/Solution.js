function solution(spells, dic) {
    
    let answer = 0;
    
    for(let word of dic){
        let isWord = true;
        for(let spell of spells){
            if(!(word.indexOf(spell)>=0 && word.indexOf(spell) == word.lastIndexOf(spell))) isWord = false;
        }
        if(isWord) answer ++;
    }
        
    return answer > 0 ? 1 : 2;
}