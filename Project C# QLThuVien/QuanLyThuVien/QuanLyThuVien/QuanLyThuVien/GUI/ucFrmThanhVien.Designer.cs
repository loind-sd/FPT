namespace QuanLyThuVien
{
    partial class ucFrmThanhVien
    {
        /// <summary> 
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.rdoBtnNu = new System.Windows.Forms.RadioButton();
            this.rdoBtnNam = new System.Windows.Forms.RadioButton();
            this.dateNamSinh = new DevExpress.XtraEditors.DateEdit();
            this.labelControl1 = new DevExpress.XtraEditors.LabelControl();
            this.labelControl2 = new DevExpress.XtraEditors.LabelControl();
            this.labelControl3 = new DevExpress.XtraEditors.LabelControl();
            this.labelControl4 = new DevExpress.XtraEditors.LabelControl();
            this.labelControl5 = new DevExpress.XtraEditors.LabelControl();
            this.txt_HoTen = new DevExpress.XtraEditors.TextEdit();
            this.txt_MTV = new DevExpress.XtraEditors.TextEdit();
            this.txt_DiaChi = new DevExpress.XtraEditors.TextEdit();
            this.txt_GioiTinh = new DevExpress.XtraEditors.TextEdit();
            this.btnSua = new DevExpress.XtraEditors.SimpleButton();
            ((System.ComponentModel.ISupportInitialize)(this.dateNamSinh.Properties)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dateNamSinh.Properties.CalendarTimeProperties)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_HoTen.Properties)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_MTV.Properties)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_DiaChi.Properties)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_GioiTinh.Properties)).BeginInit();
            this.SuspendLayout();
            // 
            // rdoBtnNu
            // 
            this.rdoBtnNu.AutoSize = true;
            this.rdoBtnNu.Location = new System.Drawing.Point(364, 148);
            this.rdoBtnNu.Name = "rdoBtnNu";
            this.rdoBtnNu.Size = new System.Drawing.Size(54, 24);
            this.rdoBtnNu.TabIndex = 6;
            this.rdoBtnNu.TabStop = true;
            this.rdoBtnNu.Text = "Nữ";
            this.rdoBtnNu.UseVisualStyleBackColor = true;
            // 
            // rdoBtnNam
            // 
            this.rdoBtnNam.AutoSize = true;
            this.rdoBtnNam.Location = new System.Drawing.Point(246, 148);
            this.rdoBtnNam.Name = "rdoBtnNam";
            this.rdoBtnNam.Size = new System.Drawing.Size(67, 24);
            this.rdoBtnNam.TabIndex = 5;
            this.rdoBtnNam.TabStop = true;
            this.rdoBtnNam.Text = "Nam";
            this.rdoBtnNam.UseVisualStyleBackColor = true;
            // 
            // dateNamSinh
            // 
            this.dateNamSinh.EditValue = new System.DateTime(2021, 6, 4, 0, 0, 0, 0);
            this.dateNamSinh.Location = new System.Drawing.Point(246, 197);
            this.dateNamSinh.Name = "dateNamSinh";
            // 
            // 
            // 
            this.dateNamSinh.Properties.Buttons.AddRange(new DevExpress.XtraEditors.Controls.EditorButton[] {
            new DevExpress.XtraEditors.Controls.EditorButton(DevExpress.XtraEditors.Controls.ButtonPredefines.Combo)});
            // 
            // 
            // 
            this.dateNamSinh.Properties.CalendarTimeProperties.Buttons.AddRange(new DevExpress.XtraEditors.Controls.EditorButton[] {
            new DevExpress.XtraEditors.Controls.EditorButton(DevExpress.XtraEditors.Controls.ButtonPredefines.Combo)});
            this.dateNamSinh.Size = new System.Drawing.Size(146, 26);
            this.dateNamSinh.TabIndex = 8;
            // 
            // labelControl1
            // 
            this.labelControl1.Location = new System.Drawing.Point(84, 49);
            this.labelControl1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.labelControl1.Name = "labelControl1";
            this.labelControl1.Size = new System.Drawing.Size(58, 19);
            this.labelControl1.TabIndex = 10;
            this.labelControl1.Text = "Họ Tên:";
            // 
            // labelControl2
            // 
            this.labelControl2.Location = new System.Drawing.Point(84, 95);
            this.labelControl2.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.labelControl2.Name = "labelControl2";
            this.labelControl2.Size = new System.Drawing.Size(112, 19);
            this.labelControl2.TabIndex = 10;
            this.labelControl2.Text = "Mã Thành Viên:";
            // 
            // labelControl3
            // 
            this.labelControl3.Location = new System.Drawing.Point(84, 148);
            this.labelControl3.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.labelControl3.Name = "labelControl3";
            this.labelControl3.Size = new System.Drawing.Size(65, 19);
            this.labelControl3.TabIndex = 10;
            this.labelControl3.Text = "Giới Tính";
            // 
            // labelControl4
            // 
            this.labelControl4.Location = new System.Drawing.Point(84, 208);
            this.labelControl4.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.labelControl4.Name = "labelControl4";
            this.labelControl4.Size = new System.Drawing.Size(69, 19);
            this.labelControl4.TabIndex = 10;
            this.labelControl4.Text = "Năm Sinh";
            // 
            // labelControl5
            // 
            this.labelControl5.Location = new System.Drawing.Point(84, 258);
            this.labelControl5.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.labelControl5.Name = "labelControl5";
            this.labelControl5.Size = new System.Drawing.Size(57, 19);
            this.labelControl5.TabIndex = 10;
            this.labelControl5.Text = "Địa Chỉ:";
            // 
            // txt_HoTen
            // 
            this.txt_HoTen.Location = new System.Drawing.Point(246, 38);
            this.txt_HoTen.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.txt_HoTen.Name = "txt_HoTen";
            this.txt_HoTen.Size = new System.Drawing.Size(266, 26);
            this.txt_HoTen.TabIndex = 11;
            // 
            // txt_MTV
            // 
            this.txt_MTV.Location = new System.Drawing.Point(246, 78);
            this.txt_MTV.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.txt_MTV.Name = "txt_MTV";
            this.txt_MTV.Size = new System.Drawing.Size(266, 26);
            this.txt_MTV.TabIndex = 11;
            // 
            // txt_DiaChi
            // 
            this.txt_DiaChi.Location = new System.Drawing.Point(246, 248);
            this.txt_DiaChi.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.txt_DiaChi.Name = "txt_DiaChi";
            this.txt_DiaChi.Size = new System.Drawing.Size(266, 26);
            this.txt_DiaChi.TabIndex = 11;
            // 
            // txt_GioiTinh
            // 
            this.txt_GioiTinh.Location = new System.Drawing.Point(542, 298);
            this.txt_GioiTinh.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.txt_GioiTinh.Name = "txt_GioiTinh";
            // 
            // 
            // 
            this.txt_GioiTinh.Properties.Appearance.BackColor = System.Drawing.Color.Gainsboro;
            this.txt_GioiTinh.Properties.Appearance.Options.UseBackColor = true;
            this.txt_GioiTinh.Size = new System.Drawing.Size(150, 26);
            this.txt_GioiTinh.TabIndex = 12;
            this.txt_GioiTinh.Visible = false;
            // 
            // btnSua
            // 
            this.btnSua.Location = new System.Drawing.Point(246, 317);
            this.btnSua.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.btnSua.Name = "btnSua";
            this.btnSua.Size = new System.Drawing.Size(146, 43);
            this.btnSua.TabIndex = 13;
            this.btnSua.Text = "Thay đổi";
            this.btnSua.Click += new System.EventHandler(this.btnSua_Click);
            // 
            // ucFrmThanhVien
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.btnSua);
            this.Controls.Add(this.txt_DiaChi);
            this.Controls.Add(this.txt_MTV);
            this.Controls.Add(this.txt_HoTen);
            this.Controls.Add(this.labelControl5);
            this.Controls.Add(this.labelControl4);
            this.Controls.Add(this.labelControl3);
            this.Controls.Add(this.labelControl2);
            this.Controls.Add(this.labelControl1);
            this.Controls.Add(this.dateNamSinh);
            this.Controls.Add(this.rdoBtnNu);
            this.Controls.Add(this.rdoBtnNam);
            this.Controls.Add(this.txt_GioiTinh);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "ucFrmThanhVien";
            this.Size = new System.Drawing.Size(696, 424);
            this.Load += new System.EventHandler(this.ucFrmThanhVien_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dateNamSinh.Properties.CalendarTimeProperties)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dateNamSinh.Properties)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_HoTen.Properties)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_MTV.Properties)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_DiaChi.Properties)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.txt_GioiTinh.Properties)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton rdoBtnNu;
        private System.Windows.Forms.RadioButton rdoBtnNam;
        private DevExpress.XtraEditors.DateEdit dateNamSinh;
        private DevExpress.XtraEditors.LabelControl labelControl1;
        private DevExpress.XtraEditors.LabelControl labelControl2;
        private DevExpress.XtraEditors.LabelControl labelControl3;
        private DevExpress.XtraEditors.LabelControl labelControl4;
        private DevExpress.XtraEditors.LabelControl labelControl5;
        private DevExpress.XtraEditors.TextEdit txt_HoTen;
        private DevExpress.XtraEditors.TextEdit txt_MTV;
        private DevExpress.XtraEditors.TextEdit txt_DiaChi;
        private DevExpress.XtraEditors.TextEdit txt_GioiTinh;
        private DevExpress.XtraEditors.SimpleButton btnSua;
    }
}
