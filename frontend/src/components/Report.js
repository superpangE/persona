import React from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "@material-tailwind/react";
import ReportCompleted from "./ReportCompleted";

export default function Report(props) {
  const { isOpen, onCancel } = props;
  const handleReportClose = () => {
    onCancel();
  };
  const [reportCompletedModal, setReportCompletedModal] = React.useState(false);
  const handleReportCompletedClose = () => {
    setReportCompletedModal(false);
  };

  return (
    <>
      <Modal size="regular" active={isOpen} toggler={() => handleReportClose(false)}>
        <ModalHeader className="text-center" toggler={() => handleReportClose(false)}>
          <span>신고</span>
        </ModalHeader>
        <hr className="mb-5" />
        <ModalBody>
          <select className="bg-white rounded-lg w-full h-9 mb-3 p-2 text-xs border border-gray-300 outline-sky-500 text-black">
            <option className="rounded-lg h-10" value="0">
              욕설 / 도배
            </option>
            <option className="rounded-lg h-10" value="1">
              스팸 / 광고
            </option>
            <option className="rounded-lg h-10" value="2">
              거짓 정보
            </option>
            <option className="rounded-lg h-10" value="3">
              기타 사유
            </option>
          </select>
          <br />
          <textarea className="bg-slate-100 rounded" name="" id="" cols="70" rows="10" placeholder="신고 내용을 작성해주세요."></textarea>
        </ModalBody>
        <ModalFooter>
          <Button color="red" ripple="light" onClick={() => setReportCompletedModal(true)}>
            신고하기
          </Button>
        </ModalFooter>
        <ReportCompleted isOpen={reportCompletedModal} onCancel={handleReportCompletedClose} style={{ zIndex: 3 }} />
      </Modal>
    </>
  );
}