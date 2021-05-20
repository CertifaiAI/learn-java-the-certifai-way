/*
 * Copyright (c) 2021 CertifAI Sdn. Bhd.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
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