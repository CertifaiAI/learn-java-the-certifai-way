/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program is part of OSRFramework. You can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */
package ai.certifai.util;


import javax.swing.*;
import java.awt.*;

public class Dashboard {

    private Font font;
    private Integer counter = 1;
    private String bufferPass = "                 ";
    private String bufferFail = "                  ";
    private Color foregroundColor = Color.WHITE;

    public Dashboard()
    {
        font = new Font("SansSerif", Font.BOLD, 20);
    }

    public void show(java.util.List<Boolean> listResults) {

        JPanel panel = new JPanel(new SpringLayout());
        for (Boolean result : listResults)
        {
            JLabel counterLabel = getCounter();
            JTextField textField = getText(result);

            panel.add(counterLabel);
            counterLabel.setLabelFor(textField);
            panel.add(textField);
        }

        SpringUtilities.makeCompactGrid(panel,
                listResults.size(), 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        JFrame frame = new JFrame("Result Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setOpaque(true);
        frame.setContentPane(panel);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private JLabel getCounter()
    {
        JLabel counterLabel = new JLabel((counter++) + ".    ");
        counterLabel.setFont(font);
        counterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return counterLabel;
    }

    private JTextField getText(Boolean isCorrect)
    {
        String message;
        Color backgroundColor;

        if(isCorrect)
        {
            message = bufferPass + "PASSED" + bufferPass;
            backgroundColor = Color.GREEN;
        }
        else
        {
            message = bufferFail + "FAILED" + bufferFail;
            backgroundColor = Color.RED;
        }

        JTextField field = new JTextField(message);

        field.setFont(font);
        field.setForeground(foregroundColor);
        field.setBackground(backgroundColor);
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        field.setEditable(false);

        return field;
    }

}