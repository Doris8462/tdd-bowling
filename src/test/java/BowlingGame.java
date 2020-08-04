import java.util.Scanner;
public class BowlingGame {

    public static boolean isValid(int score){
        if(score>=0&&score<=10) return true;
        System.out.println("得分必须在0到10之间");
        return false;
    }

    public static FrameScore[] inputGoals(){
        Scanner scan=new Scanner(System.in);
        int count=0,firstScore,secondScore=0;
        FrameScore[] frames = new FrameScore[11];
        while(count<10){
            System.out.println("请输入第"+(count+1)+"轮的进球数");
            firstScore=scan.nextInt();
            if(isValid(firstScore)) {
                if (firstScore != 10) {
                    secondScore = scan.nextInt();
                    if(isValid(secondScore))
                        frames[count++] = new FrameScore(firstScore, secondScore);
                }
                else frames[count++] = new FrameScore(firstScore);
            }
        }
        System.out.println("请输入额外进球数");
        int addFirst=scan.nextInt();
        if(isValid(addFirst)) {
            if (frames[9].firstScore == 10) {
                int addSecond = scan.nextInt();
                if (isValid(addSecond))
                    frames[count] = new FrameScore(addFirst, addSecond);
            }
            else frames[count] = new FrameScore(addFirst);
        }
        return frames;
    }

     public static int calculate(FrameScore frames[]){
         int totalScore=0;
         for(int i = 0; i < 9; i++){
                 if(frames[i].firstScore == 10){
                     if(frames[i+1].firstScore==10) {
                         totalScore += frames[i + 2].firstScore + 20;
                     }
                     else totalScore += frames[i + 1].firstScore + frames[i + 1].secondScore + 10;
                 }
                 else if(frames[i].firstScore+frames[i].secondScore>=10){
                     totalScore += frames[i+1].firstScore+10;
                 }else {
                     totalScore += frames[i].firstScore+frames[i].secondScore;
                 }
             }
          totalScore+=frames[9].firstScore+frames[9].secondScore+frames[10].firstScore+frames[10].secondScore;
         System.out.println("total score is " + totalScore);
         return totalScore;
     }

    public static void main(String args[]){
        FrameScore[] frames=inputGoals();
        calculate(frames);
    }
}

