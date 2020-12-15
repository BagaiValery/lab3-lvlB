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
	
	// Ищем ячейки, строковое представление которых равно needle (иголке)
	// Применяется аналогия поиска иголки в сене, в роли сена - таблица
	private String needle = null;
	public void setNeedle(String needle) {
	this.needle = needle;
	}
	
	private DecimalFormat formatter = (DecimalFormat)NumberFormat.getInstance();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	
	public GornerTableCellRenderer() {
	// Разместить надпись внутри панели
	panel.add(label);
	// Установить выравнивание надписи по левому краю панели
	panel.setLayout(new FlowLayout(FlowLayout.LEFT));
	// Показывать только 5 знаков после запятой
	formatter.setMaximumFractionDigits(5);
	// Не использовать группировку (не отделять тысячи)
	// Т.е. показывать число как "1000", а не "1 000" или "1,000"
	formatter.setGroupingUsed(false);
	// Установить в качестве разделителя дробной части точку, а не запятую
	// По умолчанию дробная часть
	// отделяется запятой
	DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
	dottedDouble.setDecimalSeparator('.');
	formatter.setDecimalFormatSymbols(dottedDouble);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object
			value, boolean isSelected, boolean hasFocus, int row, int col) {
			// Преобразовать число в строку с помощью форматировщика
			String formattedDouble = formatter.format(value);
			String razdel = "\\.";
			String[] str;
			String copy = formattedDouble + ".0";
			str = copy.split(razdel);
			int _int=Integer.parseInt(str[0]);
			
			if (col==1 && _int%2==0)panel.setBackground(Color.ORANGE);
			else panel.setBackground(Color.WHITE);
			
			if (col==0 && needle!=null && needle.equals(formattedDouble)) {
			// Номер столбца = 1 (т.е. второй столбец)
			// + иголка не null (т.е. мы что-то ищем)
			// + значение иголки совпадает со значением ячейки таблицы -
			// окрасить задний фон панели в красный цвет
			panel.setBackground(Color.PINK);
			}
			// Установить текст надписи равным строковому представлению числа
			label.setText(formattedDouble);
			
			return panel;
			}

}
