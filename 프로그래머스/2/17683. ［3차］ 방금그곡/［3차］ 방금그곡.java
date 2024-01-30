import java.util.*;

class Solution {
    private List<String> neoLyrics = Arrays.asList("C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#", "A", "A#", "B");
    
    class MusicInfo {
        String musicTitle;
        int index;
        int playTime;
        
        MusicInfo(String musicTitle, int index, int playTime) {
            this.musicTitle = musicTitle;
            this.index = index;
            this.playTime = playTime;
        }
    }
    
    private Queue<String> initQueue(String m) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < m.length(); i++) {
            if (i + 1 < m.length() && m.charAt(i+1) == '#') {
                if (neoLyrics.contains(String.valueOf(m.charAt(i)) + "#")) {
                    queue.offer(String.valueOf(m.charAt(i)) + "#");
                    i++;   
                    continue;
                }
            }
            queue.offer(String.valueOf(m.charAt(i)));
        }
        
        return queue;
    }
    
    private String[] initNote(int totalMinutes, String musicLyrics) {    
        String[] note = new String[totalMinutes];
        int index = 0;
        for (int i = 0; i < totalMinutes; i++) {
            if (index >= musicLyrics.length()) {
                index = 0;
            }
            
            if (index + 1 < musicLyrics.length() && musicLyrics.charAt(index + 1) == '#') {
                note[i] = String.valueOf(musicLyrics.charAt(index)) + "#";
                index += 2;
                continue;
            }

            note[i] = String.valueOf(musicLyrics.charAt(index));
            index++;
        }
        
        return note;
    }
    
    public String solution(String m, String[] musicinfos) {
        ArrayList<MusicInfo> answers = new ArrayList<>();
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            
            String[] startInfo = musicInfo[0].split(":");
            int startMinutes = (Integer.parseInt(startInfo[0]) * 60) + Integer.parseInt(startInfo[1]);
            
            String[] endInfo = musicInfo[1].split(":");
            int endMinutes = (Integer.parseInt(endInfo[0]) * 60) + Integer.parseInt(endInfo[1]);
            
            int totalMinutes = endMinutes - startMinutes;
            
            String musicTitle = musicInfo[2];
            String musicLyrics = musicInfo[3];
            
            String[] note = initNote(totalMinutes, musicLyrics);
            
            Queue<String> initQueue = initQueue(m);
            ArrayList<Integer> targetIndexs = new ArrayList<>();
            for (int j = 0; j < note.length; j++) {
                if (initQueue.peek().equals(note[j])) {
                    targetIndexs.add(j);
                }
            }
            
            int isValidCount = 0;
            for (int k = 0; k < targetIndexs.size(); k++) {
                boolean isValidLocal = true;
                Queue<String> queue = initQueue(m);
                for (int j = targetIndexs.get(k); j < note.length; j++) {
                    if (!queue.isEmpty()) {
                        if (queue.peek().equals(note[j])) {
                            queue.poll();   
                        } else {
                            isValidLocal = false;
                            break;
                        }
                    } 
                }

                if (queue.size() > 0) {
                    isValidLocal = false;
                }   
                
                if (isValidLocal) {
                    isValidCount++;
                }
            }
            
            if (isValidCount > 0) {
                answers.add(new MusicInfo(musicTitle, i, totalMinutes));
            }
        }
        
        if (answers.size() == 0) {
            return "(None)";
        }
        
        Collections.sort(answers, (MusicInfo1, MusicInfo2) -> {
            if (MusicInfo1.playTime == MusicInfo2.playTime) {
                return MusicInfo1.index - MusicInfo2.index;
            }
            
            return MusicInfo2.playTime - MusicInfo1.playTime;
        });
        
        String answer = answers.get(0).musicTitle;
        
        return answer;
    }
}