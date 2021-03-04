/*
    Copyright 2021 Andrei Datcu.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class record {
    // declaring variables
    JFrame recording;
    JButton stopButton = new JButton("Stop");
    Process ffmpeg;
    bmrec boxData;
    Font recordingFont;
    JLabel recordingLabel = new JLabel("Recording...");

    {
        try {
            boxData = new bmrec();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        function that is responsible for stopping
        the recording process.
    */
    public JButton getStopButton() {
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ffmpeg.destroy();
                JOptionPane.showMessageDialog(null,"File saved successfully!");
                recording.dispose();
            }
        });
        return stopButton;
    }

    /*
        function that is responsible for the recording process
        and the UI elements for the recording window.
    */
    public JFrame getRecording(String output, int width, int height, int framerate,String preset, String args ,boolean useAudio, int outputIndex, int channels) throws IOException {
        recording = new JFrame("Recording...");
        recording.setLocationRelativeTo(null);
        recording.setVisible(true);
        recording.setSize(new Dimension(200,100));
        recording.setLayout(new FlowLayout(FlowLayout.CENTER));
        recording.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        recordingFont = recordingLabel.getFont();
        recordingLabel.setFont(new Font(recordingFont.getName(),Font.BOLD,20));
        recording.add(recordingLabel);
        recording.add(getStopButton());

        // this is where all the magic happens.
        String[] cmd;
        String ffmpegCommand;
        if(useAudio){
            ffmpegCommand = "ffmpeg -video_size " + width + "x" + height + " -framerate " + framerate + " -f x11grab -i :0.0+0,0 -f pulse -ac "+ channels + " -i "+ outputIndex +" -c:v libx264rgb -crf 0 -preset " + preset + " " + output + " " + args;
        }
        else{
            ffmpegCommand = "ffmpeg -video_size " + width + "x" + height + " -framerate " + framerate + " -f x11grab -i :0.0+0,0 -c:v libx264rgb -crf 0 -preset " + preset + " " + output + " " + args;
        }
        cmd = new String[]{"/bin/bash", "-c", ffmpegCommand};
        ffmpeg = Runtime.getRuntime().exec(cmd);
        //JOptionPane.showMessageDialog(null,"Command used : " + cmd);
        return recording;
    }
}
