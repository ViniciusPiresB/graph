package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextLoader {
    public List<String> readArrayOfText(String filePath) {
        List<String> textNodes = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();

            while (line != null) {
                line = br.readLine();
                textNodes.add(line);
            }

            textNodes.remove(textNodes.size() - 1);

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return textNodes;
    }
}