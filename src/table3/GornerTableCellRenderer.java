package table3;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
	
	// ���� ������, ��������� ������������� ������� ����� needle (������)
	// ����������� �������� ������ ������ � ����, � ���� ���� - �������
	private String needle = null;
	public void setNeedle(String needle) {
	this.needle = needle;
	}
	
	private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	
	public GornerTableCellRenderer() {
	// ���������� ������� ������ ������
	panel.add(label);
	// ���������� ������������ ������� �� ������ ���� ������
	panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	// ���������� ������ 5 ������ ����� �������
	formatter.setMaximumFractionDigits(5);
	// �� ������������ ����������� (�� �������� ������)
	// �.�. ���������� ����� ��� "1000", � �� "1 000" ��� "1,000"
	formatter.setGroupingUsed(false);
	// ���������� � �������� ����������� ������� ����� �����, � �� �������
	// �� ��������� ������� �����
	// ���������� �������
	DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
	dottedDouble.setDecimalSeparator('.');
	formatter.setDecimalFormatSymbols(dottedDouble);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object
			value, boolean isSelected, boolean hasFocus, int row, int col) {
			// ������������� ����� � ������ � ������� ��������������
			String formattedDouble = formatter.format(value);
			String razdel = "\\.";
			String[] str;
			String copy = formattedDouble + ".0";
			str = copy.split(razdel);
			int _int=Integer.parseInt(str[0]);
			
			if (col==1 && _int%2==0)panel.setBackground(Color.ORANGE);
			else panel.setBackground(Color.WHITE);
			
			if (col==0 && needle!=null && needle.equals(formattedDouble)) {
			// ����� ������� = 1 (�.�. ������ �������)
			// + ������ �� null (�.�. �� ���-�� ����)
			// + �������� ������ ��������� �� ��������� ������ ������� -
			// �������� ������ ��� ������ � ������� ����
			panel.setBackground(Color.PINK);
			}
			// ���������� ����� ������� ������ ���������� ������������� �����
			label.setText(formattedDouble);
			
			return panel;
			}

}
