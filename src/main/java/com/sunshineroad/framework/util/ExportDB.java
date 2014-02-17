package com.sunshineroad.framework.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SchemaExport export = new SchemaExport(cfg);
		// export.drop(true, true);
		export.create(true, true);
	}
}