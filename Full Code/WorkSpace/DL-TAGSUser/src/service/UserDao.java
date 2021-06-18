package service;

import hibernate.util.HibernateUtil;

import java.util.List;

import model.BuyPojo;
import model.ShopPojo;
import model.UserPojo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserDao implements MethodInterface {

	@Override
	public boolean saveUser(UserPojo userPojo) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("email", userPojo.getEmail()));
			List<UserPojo> list = cr.list();
			if (list.isEmpty()) {
				session.save(userPojo);
				result = true;
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public String loginUser(String email, String password) {
		String result = "no";
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("password", password));
			List<UserPojo> list = cr.list();
			if (!list.isEmpty()) {
				for (UserPojo userPojo : list) {
					result = userPojo.getName();
				}
				result = result;
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean saveProducts(BuyPojo buyPojo) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(BuyPojo.class);
			List<BuyPojo> list = cr.list();
			session.save(buyPojo);
			result = true;
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<BuyPojo> purchasedProducts() {
		List<BuyPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(BuyPojo.class);
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	@Override
	public boolean updateSavedProducts(String email, String date) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(BuyPojo.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("date", date));
			List<BuyPojo> list = cr.list();
			if (!list.isEmpty()) {
				BuyPojo buyPojo = list.get(0);
				buyPojo.setStatus("dispatched");
				session.update(buyPojo);
				result = true;
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean saveStoreRequests(ShopPojo shopPojo) {
		boolean status = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(ShopPojo.class);
			// cr.add(Restrictions.eq("", shopPojo.getDistributor()));
			// cr.add(Restrictions.eq("", shopPojo.getProductId()));
			session.save(shopPojo);
			status = true;
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public List<ShopPojo> loadShopProducts() {
		List<ShopPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(ShopPojo.class);
			//cr.add(Restrictions.eq("status", "Accepted"));
			list = cr.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean updateStore(String productID) {
		boolean status = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(ShopPojo.class);
			cr.add(Restrictions.eq("productId", productID));
			List<ShopPojo> list = cr.list();
			ShopPojo shopPojo = list.get(0);
			shopPojo.setStatus("cleared");
			session.update(shopPojo);
			status = true;
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return status;
	}

	@Override
	public boolean updateStore(String productid, String quanity) {
		boolean status = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(ShopPojo.class);
			cr.add(Restrictions.eq("productId", productid));
			List<ShopPojo> list = cr.list();
			ShopPojo shopPojo = list.get(0);
			shopPojo.setQuanity(quanity);
			session.update(shopPojo);
			status = true;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return status;
	}

}
