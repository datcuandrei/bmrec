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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class audio {
    public String[] audioDevices;

    public String[] getAudioDevices() {
        String[] cmd = {"/bin/bash","-c","pacmd list-sources | grep device.description | cut -b 25- | sed 's/\"//'"};
        Process getSources = null;
        try {
            getSources = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert getSources != null;
        BufferedReader output = new BufferedReader(new InputStreamReader(getSources.getInputStream()));
        String outputs = null;
        List<String> getAudioDevices = new ArrayList<>();
        while (true){
            try {
                if (!((outputs = output.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            getAudioDevices.add(outputs);
        }
        audioDevices = getAudioDevices.toArray(new String[0]);
        return audioDevices;
    }
}
