//package io.github.Oleiva.utils;
//
///**
// * Created by OleIva on 16.02.2016.
// */
////public class DBInitializer {
////}
//
////package io.github.oleiva.utils;
//
//import io.github.Oleiva.dao.ItemsDao;
//import io.github.Oleiva.entity.ItemsEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Date;
//
////import io.github.oleiva.dao.UserDao;
////import io.github.oleiva.dao.NewsEntryDao;
////import io.github.oleiva.entity.NewsEntry;
////import io.github.oleiva.entity.User;
//
////import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Initialize the database with some test entries.
// */
//
//public class DBInitializer {
//
////	private NewsEntryDao newsEntryDao;
////	private UserDao userDao;
//	@Autowired
//	private ItemsDao itemsDao;
////	private PasswordEncoder passwordEncoder;
//
//
//	protected DBInitializer() {
//		/* Default constructor for reflection instantiation */
//	}
//
//
//
////	public DBInitializer(UserDao userDao, NewsEntryDao newsEntryDao, PasswordEncoder passwordEncoder) {
////		this.userDao = userDao;
////		this.newsEntryDao = newsEntryDao;
////		this.passwordEncoder = passwordEncoder;
////	}
//
//
//
//
//	public void initDataBase() {
////		User userUser = new User("user", this.passwordEncoder.encode("user"));
////		userUser.addRole("user");
////		this.userDao.save(userUser);
////
////		User adminUser = new User("admin", this.passwordEncoder.encode("admin"));
////		adminUser.addRole("user");
////		adminUser.addRole("admin");
////		this.userDao.save(adminUser);
////
////		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
////		for (int i = 0; i < 10; i++) {
////			NewsEntry newsEntry = new NewsEntry();
////			newsEntry.setContent("This is example content " + i);
////			newsEntry.setDate(new Date(timestamp));
////			this.newsEntryDao.save(newsEntry);
////			timestamp += 1000 * 60 * 60;
////		}
//
//	}
//		public void initDataItems () {
//
//			String SKU = "dd";
//			String NAME = "dd";
//			long PRICE = 10000;
//			long AMOUNT = 3434;
//
//			ItemsEntity itemsEntity = new ItemsEntity(SKU,NAME,PRICE,AMOUNT);
//			System.out.println(itemsEntity);
//
//			this.itemsDao.saveAndFlush(itemsEntity);
//		}
//
//
//		}
//
//
