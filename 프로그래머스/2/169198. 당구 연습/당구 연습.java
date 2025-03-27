class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        Point start = new Point(startX, startY);
        int[] answer = new int[balls.length];
        for(int i = 0; i < balls.length; i++){
            Point ball = new Point(balls[i][0], balls[i][1]);
            int minDist = Integer.MAX_VALUE;

            // 각 벽면에 대한 지점 위치 계산
            for(int j = 0; j < 8; j++){
                Point point = convertPoint(ball, j, m, n);
                if(isValid(j, start, point, ball, m, n)){
                    int dist = start.calcDist(point);
                    minDist = Math.min(dist, minDist);
                };
            }
            
            answer[i] = minDist;
        }
        
        return answer;
    }
    
    private boolean isValid(int direction, Point point1, Point point2, Point ball, int m, int n){
        // (y - point1.y) = ((point2.y - point1.y) / (point2.x - point1.x)) x (x - point1.x) +
        int x = ball.x;
        double slope = (point2.y - point1.y) / (double)(point2.x - point1. x);
        
        // 꼭지점
        if(direction < 4){
            int[] anglesX = {0, m, 0, m};
            int[] anglesY = {0, 0, n, n};
            
            double angleX = anglesX[direction];
            double angleY = anglesY[direction];
            double checkY = slope * (angleX * point1.x) + point1.y;
            boolean onLine = checkY == angleY;
            boolean isBetweenX = (ball.x > Math.max(point1.x, angleX)) 
                && (ball.x < Math.min(point1.x, angleX));
            boolean isBetweenY = (ball.y > Math.max(point1.y, angleY)) 
                && (ball.y < Math.min(point1.y, angleY));
            boolean isBetween = isBetweenX || isBetweenY;
            return onLine && !isBetween;
        // 벽
        }else{
            boolean isBetweenX = ball.y == point1.y
                && (ball.x < Math.max(point1.x, point2.x)) 
                && (ball.x > Math.min(point1.x, point2.x));
            boolean isBetweenY = ball.x == point1.x
                && (ball.y < Math.max(point1.y, point2.y)) 
                && (ball.y > Math.min(point1.y, point2.y));
            return !isBetweenX && !isBetweenY;
        }
        
    }
    
    private Point convertPoint(Point point, int line, int m, int n){
        int x = 0;
        int y = 0;
        
        switch(line){
            case 0: // 원점
                x = 0 - point.x;
                y = 0 - point.y;
                break;
            case 1: // 우하
                x = m + (m - point.x);
                y = 0 - point.y;
                break;
            case 2: // 좌상
                x = 0 - point.x;
                y = n + (n - point.y);
                break;
            case 3: // 우상
                x = m + (m - point.x);
                y = n + (n - point.y);
                break;
            case 4: // 좌
                x = 0 - point.x; 
                y = point.y;
                break;
            case 5: // 위
                x = point.x;
                y = n + (n - point.y);
                break;
            case 6: // 우
                x = m + (m - point.x);
                y = point.y;
                break;
            case 7: // 하
                x = point.x;
                y = 0 - point.y;
                break;
        }
        
        return new Point(x, y);
    }

    public static class Point{
        int x;
        int y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }   
            
        public int calcDist(Point o){
            return (int)Math.pow((this.x - o.x), 2) + (int)Math.pow((this.y - o.y), 2);
        }
    }
}