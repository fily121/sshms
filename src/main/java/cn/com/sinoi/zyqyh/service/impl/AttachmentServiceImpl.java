package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.AttachmentMapper;
import cn.com.sinoi.zyqyh.service.IAttachmentService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Attachment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attachmentService")
public class AttachmentServiceImpl extends BaseServiceImpl<Attachment> implements IAttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public List<Attachment> findByCondition(SearchParams params) throws Exception {
        return null;
    }

    @Override
    public List<Attachment> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Attachment attachment) {
        attachmentMapper.insert(attachment);
    }
}
