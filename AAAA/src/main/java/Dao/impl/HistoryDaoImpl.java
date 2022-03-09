package Dao.impl;

import Dao.AbstractDao;
import Dao.HistoryDao;
import Entity.History;

import java.util.List;

public class HistoryDaoImpl  extends AbstractDao<History> implements HistoryDao {
    @Override
    public List<History> findByUser(String username) {
        String sql = "SELECT h FROM history h where h.user.username =?0 AND h.video.isActive=1" +
                " ORDER BY h.viewedDate DESC";
        return super.findMany(History.class,sql,username);
    }

    @Override
    public List<History> findByUserIsLiked(String username) {
        String sql = "SELECT h FROM history h where h.user.username =?0 AND h.isLiked = 1" +
                " AND h.video.isActive=1" +
                " ORDER BY h.viewedDate DESC";
        return super.findMany(History.class,sql,username);
    }

    @Override
    public History findUserIdAndVideoID(Integer userId, Integer videoId) {
        String sql ="SELECT h FROM history o WHERE o.user.userId =?0 AND o.video.videoId = ?1" +
                " AND o.video.isActive =1";
        return super.findOne(History.class,sql,userId,videoId);
    }
}
