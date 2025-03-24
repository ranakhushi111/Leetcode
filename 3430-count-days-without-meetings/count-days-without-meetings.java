import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days; // If no meetings, all days are free
        
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int nonMeetingDays = 0;
        int lastEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Count free days before this meeting starts
            if (start > lastEnd + 1) {
                nonMeetingDays += start - lastEnd - 1;
            }

            // Update lastEnd to track the latest occupied day
            lastEnd = Math.max(lastEnd, end);
        }

        // Count free days after the last meeting
        if (lastEnd < days) {
            nonMeetingDays += days - lastEnd;
        }

        return nonMeetingDays;
    }
}

