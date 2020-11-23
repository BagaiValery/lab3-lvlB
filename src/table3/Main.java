package table3;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// ���� �� ������ �� ������ ��������� ��������� ������ -
		// ���������� ���������� ����������, ����������� ����������
		if (args.length==0) {
		System.out.println("���������� ������������ ���������, ��� �������� �� ������ �� ������ ������������!");
		System.exit(-1);
		}
		// ��������������� ����� � ������� ������������� �������,
		// ������� ���������� ��������� ������
		Double[] coefficients = new Double[args.length];
		int i = 0;
		try {
			// ��������� ��� ���������, ������� ������������� �� � Double
			for (String arg: args) {
			coefficients[i++] = Double.parseDouble(arg);
			}
			}
			catch (NumberFormatException ex) {
			 // ���� �������������� ���������� - �������� �� ������ � �����������
			 System.out.println("������ �������������� ������ '" + args[i] +
			"' � ����� ���� Double");
			 System.exit(-2);
			}
			// ������� ��������� �������� ����, ������� ��� ������ �������������
			MainFrame frame = new MainFrame(coefficients);
			// ������ ��������, ����������� ��� �������� ����
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// �������� ������� ����
			frame.setVisible(true);
			}

	}

