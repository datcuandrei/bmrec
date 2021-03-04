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
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class bmrec {
    // declaring gui elements used by bmrec.form
    public JPanel mainpanel;
    public JTextField frameField;
    public JButton browseButton;
    public JComboBox formatBox;
    public JTextField locationField;
    public JButton recordButton;
    public JButton updatesButton;
    public JSpinner widthSpinner;
    public JSpinner heightSpinner;
    public JButton issuesButton;
    public JTextField argsField;
    public JTextField nameField;
    public JButton aboutButton;
    public JLabel Preset;
    public JComboBox presetBox;
    public JComboBox uiMgr;
    public JComboBox channelsBox;
    public String path = locationField.getText();
    audio audio = new audio();
    public JComboBox audioInputBox;
    public JRadioButton yesRadioButton;
    public JRadioButton noRadioButton;
    public JButton refreshButton;

    /*
        function that opens a link
        based on the OS that bmrec
        runs on.
     */
    void openLink(String webPage) {
        String root[] = {"/bin/bash", "-c", "xdg-open " + webPage};
        try {
            Process p = Runtime.getRuntime().exec(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        constructor responsible for all buttons and
        their actions.
     */
    public bmrec() throws IOException {
        /*
            adding the audio inputs to the audioInputBox.
            unfortunately,I couldn't create a new JComboBox with
            the items because it would throw a NullPointerException.
            this is the only way i got it working.
        */
        for(int i=0;i < audio.getAudioDevices().length;i++){
            Object input = audio.getAudioDevices()[i];
            audioInputBox.addItem(input);
        }
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                audio refreshAudio = new audio();
                audioInputBox.removeAllItems();
                for(int r=0;r < refreshAudio.getAudioDevices().length;r++){
                    Object src = refreshAudio.getAudioDevices()[r];
                    audioInputBox.addItem(src);

                }
            }
        });
        // responsible for browsing the computer for an output location
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser browseLocation = new JFileChooser();
                browseLocation.setDialogTitle("Browse...");
                browseLocation.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
                if (browseLocation.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    path = browseLocation.getSelectedFile().getAbsolutePath();
                    locationField.setText(path);
                    SwingUtilities.updateComponentTreeUI(mainpanel);
                }
            }
        });
        // responsible for starting the recording process
        recordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameField.getText();
                String of = path + "/" + name + formatBox.getSelectedItem().toString();
                record rec = new record();
                int width = Integer.parseInt(widthSpinner.getValue().toString());
                int height = Integer.parseInt(heightSpinner.getValue().toString());
                int framerate = Integer.parseInt(frameField.getText());
                String additionalArgs = argsField.getText();
                String preset = presetBox.getSelectedItem().toString();
                int channels = Integer.parseInt(channelsBox.getSelectedItem().toString());
                int outputIndex = audioInputBox.getSelectedIndex() + 1;
                if (width <= 100 || height <= 100) {
                    JOptionPane.showMessageDialog(null, "Please use a resolution bigger than 100x100.");
                } else {
                    try {
                        rec.getRecording(of, width, height, framerate, preset, additionalArgs,yesRadioButton.isSelected(),outputIndex,channels);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // responsible for opening the issues section in browser
        issuesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openLink("https://github.com/datcuandrei/bmrec/issues");
            }
        });
        // responsible for opening the releases page in browser
        updatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openLink("https://github.com/datcuandrei/bmrec/releases");
            }
        });
        // responsible for showing the about section
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                about about = null;
                try {
                    about = new about();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                about.getAbout();
            }
        });
        // responsible for switching the aspect of the program
        uiMgr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String mode = Objects.requireNonNull(uiMgr.getSelectedItem()).toString();
                if (mode.equals("Dark")) {
                    try {
                        UIManager.setLookAndFeel(new FlatDarculaLaf());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        UIManager.setLookAndFeel(new FlatLightLaf());
                    } catch (UnsupportedLookAndFeelException e) {
                        e.printStackTrace();
                    }
                }
                SwingUtilities.updateComponentTreeUI(mainpanel);
            }
        });
        ButtonGroup audioYN = new ButtonGroup();

        yesRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                channelsBox.setEnabled(true);
                audioInputBox.setEnabled(true);
                yesRadioButton.setSelected(true);
                SwingUtilities.updateComponentTreeUI(mainpanel);
            }
        });
        noRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                channelsBox.setEnabled(false);
                audioInputBox.setEnabled(false);
                noRadioButton.setSelected(true);
                SwingUtilities.updateComponentTreeUI(mainpanel);
            }
        });

        audioYN.add(yesRadioButton);
        audioYN.add(noRadioButton);
    }

    /*
        the main method which is responsible for showing
        the frame
    */
    public static void main(String args[]) throws UnsupportedLookAndFeelException, IOException {
        // by default, bmrec starts in light mode.
        UIManager.setLookAndFeel(new FlatLightLaf());
        JFrame frame = new JFrame("bmrec");
        frame.setVisible(true);
        frame.setContentPane(new bmrec().mainpanel);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(650, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
