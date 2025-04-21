import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int cnt = plays.length;

        Map<String, Genre> genreInfo = new HashMap<>();
        Map<Genre, PriorityQueue<Music>> musicInfo = new HashMap<>();
        for(int i = 0; i < cnt; i++){
            String name = genres[i];
            int play = plays[i];

            Genre genre = genreInfo.compute(name, (nameKey, savedGenre) -> {
                Genre info = savedGenre == null ? new Genre(name) : savedGenre;
                info.addPlays(play);
                return info;
            });

            int musicNum = i;
            musicInfo.compute(genre, (genreKey, savedMusicList) -> {
               PriorityQueue<Music> musicList = savedMusicList == null ? new PriorityQueue<>() : savedMusicList;
                musicList.add(new Music(musicNum, play, genre));
                return musicList;
            });
        }

        PriorityQueue<Genre> orderedGenre = new PriorityQueue<>();
        orderedGenre.addAll(genreInfo.values());

        List<Integer> answerList = new ArrayList<>();

        while(!orderedGenre.isEmpty()){
            Genre genre = orderedGenre.poll();
            PriorityQueue<Music> genreMusic = musicInfo.get(genre);
            int pickSize = Math.min(genreMusic.size(), 2);
            for(int i = 0; i < pickSize; i++){
                answerList.add(genreMusic.poll().num);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Genre implements Comparable<Genre>{
        String name;
        int plays = 0;

        Genre(String name) {
            this.name = name;
        }

        public void addPlays(int play){
            this.plays = this.plays + play;
        }

        @Override
        public int compareTo(Genre o) {
            return o.plays - this.plays;
        }
    }

    private static class Music implements Comparable<Music>{
        int num;
        int plays;
        Genre genres;

        Music(int num, int plays, Genre genres){
            this.num = num;
            this.plays = plays;
            this.genres = genres;
        }

        @Override
        public int compareTo(Music o) {
            return o.plays - this.plays;
        }
    }
}