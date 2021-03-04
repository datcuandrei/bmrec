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

public class about {
    public JFrame about;
    public JButton credits = new JButton("Credits");
    public JButton authorPage = new JButton("Author's page");
    bmrec links = new bmrec();

    public about() throws IOException {
    }

    /*
        function responsible for the credits button action;
        shows the credits page.
     */
    public JButton getCredits() {
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame credits = new JFrame("Credits");
                credits.setVisible(true);
                credits.setSize(800,320);
                credits.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                credits.setLocationRelativeTo(null);
                credits.setLayout(new FlowLayout(FlowLayout.CENTER));

                JTextPane text = new JTextPane();
                text.setContentType("text/html");
                text.setText("<html><head></head><body><div align=\"center\"><h1>Credits</h1><p>• bmrec's UI would have not been possible without <b>FlatLaf</b> library,which is licensed under Apache License, Version 2.0</p><p>• bmrec is based on FFmpeg,which is licensed under the GNU Lesser General Public License (LGPL) version 2.1 or later.</p><p>• Special thanks to the <b>Unsupported Macs</b> community.</p><br/><p><b>FlatLaf</b> : https://www.formdev.com/flatlaf/</p><p><b>FFmpeg</b> : https://www.ffmpeg.org/</p><p><b>Unsupported Macs</b> : https://discord.gg/XbbWAsE</p></div></body></html>");
                text.setEditable(false);

                credits.add(text);
            }
        });
        return credits;
    }
    /*
        function responsible for the author's page button action;
        redirects to datcuandrei.github.io
     */
    public JButton getAuthorPage() {
        authorPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                links.openLink("https://datcuandrei.github.io");
            }
        });
        return authorPage;
    }

    /*
        function responsible for the about button action
        found in bmrec.java; shows the about page.
     */
    public JFrame getAbout() {
        JFrame about = new JFrame("About");
        about.setVisible(true);
        about.setSize(530,320);
        about.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        about.setLocationRelativeTo(null);
        about.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextPane text = new JTextPane();
        text.setContentType("text/html");
        text.setText("<html><head></head><body><div align=\"center\"><h1>bmrec</h1><h2>1.0</h2><br><p>bmrec is a fast and easy to use screen recording software,based on FFmpeg.</p><br><p>Copyright © 2021 Andrei Datcu.<br>Licensed under the GNU General Public License, Version 3.0<br>Powered by open-source software,see Credits for more information.</p></div></body></html>");
        text.setEditable(false);

        about.add(text);
        about.add(getCredits());
        about.add(getAuthorPage());
        return about;
    }
}
