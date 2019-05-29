package com.test.myworld;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class worldgraph {

	private static int vertexSize;

	private static double[][] matrix;

	private static Map<Integer, String> allhouses;

	public int getVertexSize() {
		return vertexSize;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public static Map<Integer, String> getAllhouses() {
		return allhouses;
	}

	private static Connection conn;

	public static String[][] datamap;

	public String[][] getData() {
		return datamap;
	}

	static {
		allhouses = new HashMap<Integer , String>();
		getConn();
		// 获取所有的节点信息
		getallpoints();
		matrix = new double[vertexSize][vertexSize];
		// 获取数据信息构建矩阵
		datamap = new String[vertexSize+1][vertexSize+1];
		datamap[0][0] = "data";
		getvalue();
		datamap[0][0] = "data";
	}

	private static void getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/globalconf";
		String username = "root";
		String password = "123456";
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void getallpoints() {
		String sql = "select * from houseofmoney";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vertexSize++;
				String point = rs.getString(2) + "_" + rs.getString(3);
				allhouses.put(vertexSize, point);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void getvalue() {
		for (Map.Entry<Integer, String> vdata : allhouses.entrySet()) {
			String[] vdatas = vdata.getValue().split("_");
			for (Map.Entry<Integer, String> hdata : allhouses.entrySet()) {
				datamap[vdata.getKey()][0] = vdata.getValue();
				datamap[vdata.getKey()-1][hdata.getKey()] = hdata.getValue();
				if (vdata.equals(hdata)) {
					matrix[vdata.getKey() - 1][hdata.getKey() - 1] = 0;
					datamap[vdata.getKey()][hdata.getKey()] = "0";
					continue;
				}
				String sql = "select cost from " + vdatas[0] + "transfer where fromccy = '" + vdatas[1]
						+ "' and tohousename = '" + hdata.getValue().split("_")[0] + "' and toccy = '"
						+ hdata.getValue().split("_")[1] + "'";
				PreparedStatement pstmt;
				int count=0;
				try {
					pstmt = (PreparedStatement) conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						count++;
						matrix[vdata.getKey() - 1][hdata.getKey() - 1] = Double.valueOf(rs.getString(1));
					}
					if(count == 0) {
						matrix[vdata.getKey() - 1][hdata.getKey() - 1] = Integer.MAX_VALUE;
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}