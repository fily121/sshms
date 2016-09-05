package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Attachment;

public interface IAttachmentService extends IBaseService<Attachment> {

    void save(Attachment attachment);

    Attachment findbyId(String attachmentId);

}
